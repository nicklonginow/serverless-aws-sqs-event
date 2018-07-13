package com.amazonaws.serverless.sqseventsource.dagger;

import com.amazonaws.services.sqs.AmazonSQS;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideAmazonSQSFactory implements Factory<AmazonSQS> {
  private final AppModule module;

  public AppModule_ProvideAmazonSQSFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public AmazonSQS get() {
    return Preconditions.checkNotNull(
        module.provideAmazonSQS(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvideAmazonSQSFactory create(AppModule module) {
    return new AppModule_ProvideAmazonSQSFactory(module);
  }

  public static AmazonSQS proxyProvideAmazonSQS(AppModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAmazonSQS(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
