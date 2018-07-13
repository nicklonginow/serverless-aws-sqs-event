package com.amazonaws.serverless.sqseventsource.dagger;

import com.amazonaws.serverless.sqseventsource.MessageDispatcher;
import com.amazonaws.serverless.sqseventsource.MessageProcessorProxy;
import com.amazonaws.serverless.sqseventsource.SQSPoller;
import com.amazonaws.serverless.sqseventsource.SQSProxy;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.sqs.AmazonSQS;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<AmazonSQS> provideAmazonSQSProvider;

  private Provider<SQSProxy> provideSQSProxyProvider;

  private Provider<AWSLambda> provideAWSLambdaProvider;

  private Provider<MessageProcessorProxy> provideMessageProcessorProxyProvider;

  private Provider<MessageDispatcher> providesMessageDispatcherProvider;

  private Provider<SQSPoller> provideSQSPollerProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideAmazonSQSProvider =
        DoubleCheck.provider(AppModule_ProvideAmazonSQSFactory.create(builder.appModule));
    this.provideSQSProxyProvider =
        DoubleCheck.provider(
            AppModule_ProvideSQSProxyFactory.create(builder.appModule, provideAmazonSQSProvider));
    this.provideAWSLambdaProvider =
        DoubleCheck.provider(AppModule_ProvideAWSLambdaFactory.create(builder.appModule));
    this.provideMessageProcessorProxyProvider =
        DoubleCheck.provider(
            AppModule_ProvideMessageProcessorProxyFactory.create(
                builder.appModule, provideAWSLambdaProvider));
    this.providesMessageDispatcherProvider =
        DoubleCheck.provider(
            AppModule_ProvidesMessageDispatcherFactory.create(
                builder.appModule, provideSQSProxyProvider, provideMessageProcessorProxyProvider));
    this.provideSQSPollerProvider =
        DoubleCheck.provider(
            AppModule_ProvideSQSPollerFactory.create(
                builder.appModule, provideSQSProxyProvider, providesMessageDispatcherProvider));
  }

  @Override
  public SQSPoller getSQSPoller() {
    return provideSQSPollerProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}
