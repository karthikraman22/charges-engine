package in.achuala.core.common;

import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.ExceptionHandlerFunction;

public final class LocalExceptionHandler implements ExceptionHandlerFunction {
    @Override
    public HttpResponse handleException(ServiceRequestContext ctx, HttpRequest req, Throwable cause) {
        if (cause instanceof ExceptionHandlerService.LocallySpecificException) {
            return HttpResponse.of(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if (cause instanceof ExceptionHandlerService.LocallyGeneralException) {
            return HttpResponse.of(HttpStatus.BAD_REQUEST);
        }
        // To the next exception handler.
        return ExceptionHandlerFunction.fallthrough();
    }
}