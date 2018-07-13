package com.amazonaws.serverless.sqseventsource.dagger;

import com.amazonaws.serverless.sqseventsource.MessageDispatcher;
import com.amazonaws.serverless.sqseventsource.SQSPoller;
import com.amazonaws.serverless.sqseventsource.SQSProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideSQSPollerFactory implements Factory<SQSPoller> {
  private final AppModule module;

  private final Provider<SQSProxy> sqsProxyProvider;

  private final Provider<MessageDispatcher> messageDispatcherProvider;

  public AppModule_ProvideSQSPollerFactory(
      AppModule module,
      Provider<SQSProxy> sqsProxyProvider,
      Provider<MessageDispatcher> messageDispatcherProvider) {
    this.module = module;
    this.sqsProxyProvider = sqsProxyProvider;
    this.messageDispatcherProvider = messageDispatcherProvider;
  }

  @Override
  public SQSPoller get() {
    return Preconditions.checkNotNull(
        module.provideSQSPoller(sqsProxyProvider.get(), messageDispatcherProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvideSQSPollerFactory create(
      AppModule module,
      Provider<SQSProxy> sqsProxyProvider,
      Provider<MessageDispatcher> messageDispatcherProvider) {
    return new AppModule_ProvideSQSPollerFactory(
        module, sqsProxyProvider, messageDispatcherProvider);
  }

  public static SQSPoller proxyProvideSQSPoller(
      AppModule instance, SQSProxy sqsProxy, MessageDispatcher messageDispatcher) {
    return Preconditions.checkNotNull(
        instance.provideSQSPoller(sqsProxy, messageDispatcher),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
