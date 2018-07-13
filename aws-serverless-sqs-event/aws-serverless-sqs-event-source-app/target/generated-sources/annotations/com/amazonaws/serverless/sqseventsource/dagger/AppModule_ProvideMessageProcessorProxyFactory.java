package com.amazonaws.serverless.sqseventsource.dagger;

import com.amazonaws.serverless.sqseventsource.MessageProcessorProxy;
import com.amazonaws.services.lambda.AWSLambda;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideMessageProcessorProxyFactory
    implements Factory<MessageProcessorProxy> {
  private final AppModule module;

  private final Provider<AWSLambda> lambdaProvider;

  public AppModule_ProvideMessageProcessorProxyFactory(
      AppModule module, Provider<AWSLambda> lambdaProvider) {
    this.module = module;
    this.lambdaProvider = lambdaProvider;
  }

  @Override
  public MessageProcessorProxy get() {
    return Preconditions.checkNotNull(
        module.provideMessageProcessorProxy(lambdaProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvideMessageProcessorProxyFactory create(
      AppModule module, Provider<AWSLambda> lambdaProvider) {
    return new AppModule_ProvideMessageProcessorProxyFactory(module, lambdaProvider);
  }

  public static MessageProcessorProxy proxyProvideMessageProcessorProxy(
      AppModule instance, AWSLambda lambda) {
    return Preconditions.checkNotNull(
        instance.provideMessageProcessorProxy(lambda),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
