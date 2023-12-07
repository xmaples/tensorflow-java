## gcc: error

**Error:**

```
[156 / 8,374] Creating runfiles tree bazel-out/host/bin/external/org_tensorflow/tensorflow/cc/ops/sparse_ops_gen_cc.runfiles [for host]; 1s local ... (8 actions running)
ERROR: /root/.cache/bazel/_bazel_root/9ee07e3d3012621de3ee013202a3fe0b/external/icu/BUILD.bazel:33:11: C++ compilation of rule '@icu//:icuuc' failed (Exit 1): gcc failed: error executing command 
  (cd /root/.cache/bazel/_bazel_root/9ee07e3d3012621de3ee013202a3fe0b/execroot/tensorflow_core_api && \
  exec env - \
    PATH=/mnt/data2/bin:/mnt/data2/apache-maven-3.9.5/bin:/mnt/data2/bin:/root/.vscode-server/bin/2b35e1e6d88f1ce073683991d1eff5284a32690f/bin/remote-cli:/mnt/data2/bin:/mnt/data2/apache-maven-3.9.5/bin:/mnt/data2/bin:/usr/lib/java/jdk1.8.0_171/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin \
    PWD=/proc/self/cwd \
    PYTHON_BIN_PATH=/usr/bin/python3 \
    PYTHON_LIB_PATH=/usr/lib/python3/dist-packages \
    TF2_BEHAVIOR=1 \
    TF_CONFIGURE_IOS=0 \
  /usr/bin/gcc -U_FORTIFY_SOURCE -fstack-protector -Wall -Wunused-but-set-parameter -Wno-free-nonheap-object -fno-omit-frame-pointer -g0 -O2 '-D_FORTIFY_SOURCE=1' -DNDEBUG -ffunction-sections -fdata-sections '-std=c++0x' -MD -MF bazel-out/aarch64-opt/bin/external/icu/_objs/icuuc/unormcmp.pic.d '-frandom-seed=bazel-out/aarch64-opt/bin/external/icu/_objs/icuuc/unormcmp.pic.o' -fPIC -iquote external/icu -iquote bazel-out/aarch64-opt/bin/external/icu -isystem external/icu/icu4c/source/common -isystem bazel-out/aarch64-opt/bin/external/icu/icu4c/source/common -w -DAUTOLOAD_DYNAMIC_KERNELS -msse4.1 -msse4.2 -mavx '-std=c++14' -DU_COMMON_IMPLEMENTATION -DU_HAVE_STD_ATOMICS -fno-canonical-system-headers -Wno-builtin-macro-redefined '-D__DATE__="redacted"' '-D__TIMESTAMP__="redacted"' '-D__TIME__="redacted"' -c external/icu/icu4c/source/common/unormcmp.cpp -o bazel-out/aarch64-opt/bin/external/icu/_objs/icuuc/unormcmp.pic.o)
Execution platform: @local_execution_config_platform//:platform
gcc: error: unrecognized command line option '-msse4.1'
gcc: error: unrecognized command line option '-msse4.2'
gcc: error: unrecognized command line option '-mavx'
```

**Solution:**

remove gcc options about x86 instruction sets (sse,avx...) in `tensorflow-core/tensorflow-core-api/build.sh`

gcc options for arm can be found here: https://gcc.gnu.org/onlinedocs/gcc/ARM-Options.html

## undeclared inclusion(s) in rule

```
ERROR: /path/to/file/BUILD:x:x: undeclared inclusion(s) in rule '//xx:xx':
this rule is missing dependency declarations for the following files included by 'xx/xx.cc':
  '/path/to/c-or-cpp/source/file'
  ...
```

**Solution:**

Did you change(upgrade/downgrade) the gcc version between two building runs? 

Change the version back to the previous, or clean bazel workspace by `bazel clean --expunge`, before your next building run.


## Bazel Server terminated abruptly

```
...
[5,486 / 8,608] Compiling org_tensorflow/tensorflow/core/kernels/set_kernels.cc; 8s local ... (8 actions, 7 running)
[5,680 / 8,608] Compiling org_tensorflow/tensorflow/compiler/xla/service/hlo_verifier.cc; 9s local ... (8 actions, 7 running)
[5,831 / 8,608] Compiling org_tensorflow/tensorflow/core/grappler/optimizers/data/filter_with_random_uniform_fusion.cc; 5s local ... (8 actions, 7 running)

Server terminated abruptly (error code: 14, error message: 'Socket closed', log file: '/root/.cache/bazel/_bazel_root/9ee07e3d3012621de3ee013202a3fe0b/server/jvm.out')
```

**Solution**:

Building with Limited memory usage for bazel by defining environment variable `BUILD_USER_FLAGS` , e.g. `BUILD_USER_FLAGS="-j 12"` defining up to 12GiB memory usage. 
The variable will be used for bazel build command, see details in `tensorflow-core/tensorflow-core-api/build.sh`.
```bash
env BUILD_USER_FLAGS="-j 12" ./releash.sh
```

Refer to https://github.com/tensorflow/models/issues/3647 .


##  no tensorflow_cc in java.library.path

```
[INFO] Running org.tensorflow.framework.initializers.ZerosTest
Warning: Could not load Loader: java.lang.UnsatisfiedLinkError: no jnijavacpp in java.library.path
[ERROR] Tests run: 8, Failures: 0, Errors: 8, Skipped: 0, Time elapsed: 0.167 s <<< FAILURE! - in org.tensorflow.framework.initializers.ZerosTest
[ERROR] testReproducible  Time elapsed: 0.14 s  <<< ERROR!
java.lang.UnsatisfiedLinkError: no jnitensorflow in java.library.path
	at org.tensorflow.framework.initializers.ZerosTest.testReproducible(ZerosTest.java:146)
Caused by: java.lang.UnsatisfiedLinkError: no tensorflow_cc in java.library.path
	at org.tensorflow.framework.initializers.ZerosTest.testReproducible(ZerosTest.java:146)
```


## [ERROR] xxxx-xx-xx xx:xx:xx xxx: x external/org_tensorflow/

```
[INFO] Running org.tensorflow.GraphOperationBuilderTest
[ERROR] 2023-11-09 21:36:36.187701: W external/org_tensorflow/tensorflow/core/framework/op_kernel.cc:1763] OP_REQUIRES failed at queue_op.cc:109 : Invalid argument: Shape mismatch in tuple component 1. Expected [2,2,2,2], got [2,2,2]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.014 s - in org.tensorflow.GraphOperationBuilderTest
[INFO] Running org.tensorflow.SavedModelBundleTest
[ERROR] 2023-11-09 21:36:36.240227: I external/org_tensorflow/tensorflow/cc/saved_model/reader.cc:32] Reading SavedModel from: /tmp/tf-saved-model-export-test2168544539555650812
[ERROR] 2023-11-09 21:36:36.240365: I external/org_tensorflow/tensorflow/cc/saved_model/reader.cc:55] Reading meta graph with tags { serve }
[ERROR] 2023-11-09 21:36:36.240377: I external/org_tensorflow/tensorflow/cc/saved_model/reader.cc:93] Reading SavedModel debug info (if present) from: /tmp/tf-saved-model-export-test2168544539555650812
[ERROR] 2023-11-09 21:36:36.240624: I external/org_tensorflow/tensorflow/cc/saved_model/loader.cc:206] Restoring SavedModel bundle.
[ERROR] 2023-11-09 21:36:36.242875: I external/org_tensorflow/tensorflow/cc/saved_model/loader.cc:277] SavedModel load for tags { serve }; Status: success: OK. Took 2653 microseconds.
...
```

Ignore.
[ERROR]...: W exernal ... ==> just a warning. [ERROR]...: I exernal/... ==> just an information.
Refer to https://github.com/tensorflow/tensorflow/issues/38260 .

## ERROR: ... failed (Exit 4): gcc failed

ERROR: /root/.cache/bazel/_bazel_root/aaae759fc86880301b09ef46d2484053/external/org_tensorflow/tensorflow/core/kernels/BUILD:1107:18: C++ compilation of rule '@org_tensorflow//tensorflow/core/kernels:pad_op' failed (Exit 4): gcc failed: error executing command 
  (cd /root/.cache/bazel/_bazel_root/aaae759fc86880301b09ef46d2484053/execroot/tensorflow_core_api && \
  exec env - \
  ....
failed (Exit 4): gcc failed: error executing command ...
....
gcc: internal compiler error: Killed (program cc1plus)

**Solution**:

insufficient memory? 
(1) Set a higher maximum memory if `-j <N>` option specified for `bazel build`;
(2) or enable swap by following commonds:

```bash
# make a 2GiB swap file
sudo dd if=/dev/zero of=/swapfile bs=64M count=32
sudo chmod 0600 /swapfile
sudo swapon /swapfile
```

You maybe want to disable swap after all works done:
```bash
sudo swapon --show    # show swap on or off
sudo swapoff /swapfile
```

## tensorflow-framework module tests failure

```
[ERROR] testReproducible  Time elapsed: 0.14 s  <<< ERROR!
java.lang.UnsatisfiedLinkError: no jnitensorflow in java.library.path
	at org.tensorflow.framework.initializers.ZerosTest.testReproducible(ZerosTest.java:146)
Caused by: java.lang.UnsatisfiedLinkError: no tensorflow_cc in java.library.path
	at org.tensorflow.framework.initializers.ZerosTest.testReproducible(ZerosTest.java:146)

[ERROR] testCallFloat  Time elapsed: 0.001 s  <<< ERROR!
java.lang.NoClassDefFoundError: Could not initialize class org.tensorflow.EagerSession
	at org.tensorflow.framework.initializers.ZerosTest.testCallFloat(ZerosTest.java:90)
```
and much more error caused by `java.lang.UnsatisfiedLinkError` and `java.lang.NoClassDefFoundError`.

**Solution**:

Maybe you can include the dependency tensorflow-platform with classifier. (TODO: arch-adaptive needed)

##

```
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.504 s <<< FAILURE! - in org.tensorflow.framework.constraints.MinMaxNormTest
[ERROR] testCall  Time elapsed: 0.493 s  <<< FAILURE!
org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
        at org.tensorflow.framework.constraints.MinMaxNormTest.evaluate(MinMaxNormTest.java:61)
        at org.tensorflow.framework.constraints.MinMaxNormTest.testCall(MinMaxNormTest.java:45)
...
[ERROR] Failures: 
[ERROR]   MinMaxNormTest.testCall:45->evaluate:61 expected: <true> but was: <false>
[INFO] 
[ERROR] Tests run: 323, Failures: 1, Errors: 0, Skipped: 0
```

Well, may be numerical computation errors?

This test runs successfully on x86.

**Solution**:
??? (TODO)
