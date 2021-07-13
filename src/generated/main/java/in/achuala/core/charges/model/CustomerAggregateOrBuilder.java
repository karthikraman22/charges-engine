// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Aggregates.proto

package in.achuala.core.charges.model;

public interface CustomerAggregateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:charges.CustomerAggregate)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>string customerId = 1;</code>
   * @return The customerId.
   */
  java.lang.String getCustomerId();
  /**
   * <code>string customerId = 1;</code>
   * @return The bytes for customerId.
   */
  com.google.protobuf.ByteString
      getCustomerIdBytes();

  /**
   * <code>map&lt;string, .charges.AggrCount&gt; totalTransactions = 2;</code>
   */
  int getTotalTransactionsCount();
  /**
   * <code>map&lt;string, .charges.AggrCount&gt; totalTransactions = 2;</code>
   */
  boolean containsTotalTransactions(
      java.lang.String key);
  /**
   * Use {@link #getTotalTransactionsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, in.achuala.core.charges.model.AggrCount>
  getTotalTransactions();
  /**
   * <code>map&lt;string, .charges.AggrCount&gt; totalTransactions = 2;</code>
   */
  java.util.Map<java.lang.String, in.achuala.core.charges.model.AggrCount>
  getTotalTransactionsMap();
  /**
   * <code>map&lt;string, .charges.AggrCount&gt; totalTransactions = 2;</code>
   */

  in.achuala.core.charges.model.AggrCount getTotalTransactionsOrDefault(
      java.lang.String key,
      in.achuala.core.charges.model.AggrCount defaultValue);
  /**
   * <code>map&lt;string, .charges.AggrCount&gt; totalTransactions = 2;</code>
   */

  in.achuala.core.charges.model.AggrCount getTotalTransactionsOrThrow(
      java.lang.String key);

  /**
   * <code>map&lt;string, .charges.AggrSum&gt; totalValue = 3;</code>
   */
  int getTotalValueCount();
  /**
   * <code>map&lt;string, .charges.AggrSum&gt; totalValue = 3;</code>
   */
  boolean containsTotalValue(
      java.lang.String key);
  /**
   * Use {@link #getTotalValueMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, in.achuala.core.charges.model.AggrSum>
  getTotalValue();
  /**
   * <code>map&lt;string, .charges.AggrSum&gt; totalValue = 3;</code>
   */
  java.util.Map<java.lang.String, in.achuala.core.charges.model.AggrSum>
  getTotalValueMap();
  /**
   * <code>map&lt;string, .charges.AggrSum&gt; totalValue = 3;</code>
   */

  in.achuala.core.charges.model.AggrSum getTotalValueOrDefault(
      java.lang.String key,
      in.achuala.core.charges.model.AggrSum defaultValue);
  /**
   * <code>map&lt;string, .charges.AggrSum&gt; totalValue = 3;</code>
   */

  in.achuala.core.charges.model.AggrSum getTotalValueOrThrow(
      java.lang.String key);
}
