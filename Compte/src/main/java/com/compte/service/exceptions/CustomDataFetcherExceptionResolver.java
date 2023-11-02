package com.compte.service.exceptions;

import graphql.language.SourceLocation;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CustomDataFetcherExceptionResolver extends DataFetcherExceptionResolverAdapter {

}
