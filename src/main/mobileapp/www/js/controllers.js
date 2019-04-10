app.controller('DashCtrl', function($scope, PaypalFactory) {
    $scope.subscriptionName = 'Some subscription';
    $scope.subscriptionPrice = 5;

    $scope.payWithPayPal = function() {
        PaypalFactory.initPaymentUI().then(function() {
            PaypalFactory.makePayment($scope.subscriptionPrice, $scope.subscriptionName).then(function(data) {
                console.dir(data);

                //make some additional logic based on returned data like saving to your database, showing a message to the user, etc.
                navigator.notification.alert(
                    "PayPal purchase completed successfully.",
                    null,
                    "Paypal Purchase",
                    "OK"
                );
            }, function(err) {
                console.dir(err);
                navigator.notification.alert(
                    err,
                    null,
                    "Paypal Purchase Canceled",
                    "Try Again"
                );
            });
        });
    };
})
