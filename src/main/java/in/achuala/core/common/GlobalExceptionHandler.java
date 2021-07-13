package in.achuala.core.common;

import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.ExceptionHandlerFunction;

public  final class GlobalExceptionHandler implements ExceptionHandlerFunction {
    @Override
    public HttpResponse handleException(ServiceRequestContext ctx, HttpRequest req, Throwable cause) {
        if (cause instanceof ExceptionHandlerService.GloballyGeneralException) {
            return HttpResponse.of(HttpStatus.FORBIDDEN);
        }
        // To the next exception handler.
        return ExceptionHandlerFunction.fallthrough();
    }
}