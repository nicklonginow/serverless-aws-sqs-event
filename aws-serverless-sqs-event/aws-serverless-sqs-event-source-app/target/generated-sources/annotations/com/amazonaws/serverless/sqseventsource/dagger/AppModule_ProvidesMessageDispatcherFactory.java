package com.amazonaws.serverless.sqseventsource.dagger;

import com.amazonaws.serverless.sqseventsource.MessageDispatcher;
import com.amazonaws.serverless.sqseventsource.MessageProcessorProxy;
import com.amazonaws.serverless.sqseventsource.SQSProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesMessageDispatcherFactory
    implements Factory<MessageDispatcher> {
  private final AppModule module;

  private final Provider<SQSProxy> sqsProxyProvider;

  private final Provider<MessageProcessorProxy> messageProcessorProxyProvider;

  public AppModule_ProvidesMessageDispatcherFactory(
      AppModule module,
      Provider<SQSProxy> sqsProxyProvider,
      Provider<MessageProcessorProxy> messageProcessorProxyProvider) {
    this.module = module;
    this.sqsProxyProvider = sqsProxyProvider;
    this.messageProcessorProxyProvider = messageProcessorProxyProvider;
  }

  @Override
  public MessageDispatcher get() {
    return Preconditions.checkNotNull(
        module.providesMessageDispatcher(
            sqsProxyProvider.get(), messageProcessorProxyProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvidesMessageDispatcherFactory create(
      AppModule module,
      Provider<SQSProxy> sqsProxyProvider,
      Provider<MessageProcessorProxy> messageProcessorProxyProvider) {
    return new AppModule_ProvidesMessageDispatcherFactory(
        module, sqsProxyProvider, messageProcessorProxyProvider);
  }

  public static MessageDispatcher proxyProvidesMessageDispatcher(
      AppModule instance, SQSProxy sqsProxy, MessageProcessorProxy messageProcessorProxy) {
    return Preconditions.checkNotNull(
        instance.providesMessageDispatcher(sqsProxy, messageProcessorProxy),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
