package com.mayer.jdk23.concurrency;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class ResponseHandler {
	
	//highlight to ShutdownOnFailure which enhances error handling, this is new!
    public Response handle() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<String> user = scope.fork(this::findUser);
            Supplier<Integer> order = scope.fork(this::fetchOrder);
            
            scope.join(); // Join both subtasks
            scope.throwIfFailed(); // Propagate errors if any

            //at this point all tasks are completed, because we did join first ;)
            return new Response(user.get(), order.get());
        }
    }

    private String findUser() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Pepe ja tirei a vela";
    }

    private Integer fetchOrder() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return 12345;
    }

    public static class Response {
        private final String user;
        private final Integer order;

        public Response(String user, Integer order) {
            this.user = user;
            this.order = order;
        }

        public String getUser() {
            return user;
        }

        public Integer getOrder() {
            return order;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "user='" + user + '\'' +
                    ", order=" + order +
                    '}';
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ResponseHandler handler = new ResponseHandler();
        Response response = handler.handle();
        System.out.println(response);
    }
}