// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/framework/tensor_slice.proto

package org.tensorflow.framework;

public final class TensorSliceProtos {
  private TensorSliceProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_TensorSliceProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_TensorSliceProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_TensorSliceProto_Extent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_TensorSliceProto_Extent_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,tensorflow/core/framework/tensor_slice" +
      ".proto\022\ntensorflow\"\200\001\n\020TensorSliceProto\022" +
      "3\n\006extent\030\001 \003(\0132#.tensorflow.TensorSlice" +
      "Proto.Extent\0327\n\006Extent\022\r\n\005start\030\001 \001(\003\022\020\n" +
      "\006length\030\002 \001(\003H\000B\014\n\nhas_lengthB\207\001\n\030org.te" +
      "nsorflow.frameworkB\021TensorSliceProtosP\001Z" +
      "Sgithub.com/tensorflow/tensorflow/tensor" +
      "flow/go/core/framework/tensor_slice_go_p" +
      "roto\370\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tensorflow_TensorSliceProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tensorflow_TensorSliceProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_TensorSliceProto_descriptor,
        new java.lang.String[] { "Extent", });
    internal_static_tensorflow_TensorSliceProto_Extent_descriptor =
      internal_static_tensorflow_TensorSliceProto_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_TensorSliceProto_Extent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_TensorSliceProto_Extent_descriptor,
        new java.lang.String[] { "Start", "Length", "HasLength", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}