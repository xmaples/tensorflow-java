// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/saved_object_graph.proto

package org.tensorflow.framework;

public interface FunctionSpecOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tensorflow.FunctionSpec)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Full arg spec from inspect.getfullargspec().
   * </pre>
   *
   * <code>.tensorflow.StructuredValue fullargspec = 1;</code>
   */
  boolean hasFullargspec();
  /**
   * <pre>
   * Full arg spec from inspect.getfullargspec().
   * </pre>
   *
   * <code>.tensorflow.StructuredValue fullargspec = 1;</code>
   */
  org.tensorflow.framework.StructuredValue getFullargspec();
  /**
   * <pre>
   * Full arg spec from inspect.getfullargspec().
   * </pre>
   *
   * <code>.tensorflow.StructuredValue fullargspec = 1;</code>
   */
  org.tensorflow.framework.StructuredValueOrBuilder getFullargspecOrBuilder();

  /**
   * <pre>
   * Whether this represents a class method.
   * </pre>
   *
   * <code>bool is_method = 2;</code>
   */
  boolean getIsMethod();

  /**
   * <pre>
   * The input signature, if specified.
   * </pre>
   *
   * <code>.tensorflow.StructuredValue input_signature = 5;</code>
   */
  boolean hasInputSignature();
  /**
   * <pre>
   * The input signature, if specified.
   * </pre>
   *
   * <code>.tensorflow.StructuredValue input_signature = 5;</code>
   */
  org.tensorflow.framework.StructuredValue getInputSignature();
  /**
   * <pre>
   * The input signature, if specified.
   * </pre>
   *
   * <code>.tensorflow.StructuredValue input_signature = 5;</code>
   */
  org.tensorflow.framework.StructuredValueOrBuilder getInputSignatureOrBuilder();
}