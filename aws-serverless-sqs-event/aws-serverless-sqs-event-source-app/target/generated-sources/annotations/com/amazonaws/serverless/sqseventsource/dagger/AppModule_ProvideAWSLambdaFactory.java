package com.amazonaws.serverless.sqseventsource.dagger;

import com.amazonaws.services.lambda.AWSLambda;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideAWSLambdaFactory implements Factory<AWSLambda> {
  private final AppModule module;

  public AppModule_ProvideAWSLambdaFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public AWSLambda get() {
    return Preconditions.checkNotNull(
        module.provideAWSLambda(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvideAWSLambdaFactory create(AppModule module) {
    return new AppModule_ProvideAWSLambdaFactory(module);
  }

  public static AWSLambda proxyProvideAWSLambda(AppModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAWSLambda(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
