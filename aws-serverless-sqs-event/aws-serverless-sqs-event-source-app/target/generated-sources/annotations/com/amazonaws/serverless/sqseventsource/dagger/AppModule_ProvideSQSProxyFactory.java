package com.amazonaws.serverless.sqseventsource.dagger;

import com.amazonaws.serverless.sqseventsource.SQSProxy;
import com.amazonaws.services.sqs.AmazonSQS;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideSQSProxyFactory implements Factory<SQSProxy> {
  private final AppModule module;

  private final Provider<AmazonSQS> sqsProvider;

  public AppModule_ProvideSQSProxyFactory(AppModule module, Provider<AmazonSQS> sqsProvider) {
    this.module = module;
    this.sqsProvider = sqsProvider;
  }

  @Override
  public SQSProxy get() {
    return Preconditions.checkNotNull(
        module.provideSQSProxy(sqsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvideSQSProxyFactory create(
      AppModule module, Provider<AmazonSQS> sqsProvider) {
    return new AppModule_ProvideSQSProxyFactory(module, sqsProvider);
  }

  public static SQSProxy proxyProvideSQSProxy(AppModule instance, AmazonSQS sqs) {
    return Preconditions.checkNotNull(
        instance.provideSQSProxy(sqs), "Cannot return null from a non-@Nullable @Provides method");
  }
}
