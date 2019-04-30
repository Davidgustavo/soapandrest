(function() {
  'use strict';

  this.cronapi = this.cronapi || {};



 /**
   * @category PAYPAL
   * @categoryTags Paypal|Paypal
   */
  this.cronapi.paypal = {};
   
 // this.cronapi.myfunctions = this.cronapi.myfunctions || {};
  
  
  /**
   * @type function
   * @name createPaypalApp
   * @description {{functionToPaypalApp}}
   * @multilayer false
   * @param {ObjectType.STRING} PayPalEnvironmentProduction
   * @param {ObjectType.STRING} payPalEnvironmentSandbox
   * @param {ObjectType.STATEMENTSENDER} onSuccesfulPayment
   * @param {ObjectType.STATEMENTSENDER} onCardIOComplete
   * @param {ObjectType.STATEMENTSENDER} createPayment
   * @returns {ObjectType.OBJECT}
   */
  this.cronapi.paypal.createPaypalApp = function(createPayment, onCardIOComplete, payPalEnvironmentProduction, payPalEnvironmentSandbox, onSuccesfulPayment) {
    var myPaypalApp = {
        // Application Constructor
        initialize: function() {
            this.bindEvents();
        },
        // Bind Event Listeners
        //
        // Bind any events that are required on startup. Common events are:
        // 'load', 'deviceready', 'offline', and 'online'.
        bindEvents: function() {
            document.addEventListener('deviceready', this.onDeviceReady, false);
        },
        // deviceready Event Handler
        //
        // The scope of 'this' is the event. In order to call the 'receivedEvent'
        // function, we must explicity call 'app.receivedEvent(...);'
        onDeviceReady: function() {
            app.receivedEvent('deviceready');
        },
        // Update DOM on a Received Event
        receivedEvent: function(id) {
            var parentElement = document.getElementById(id);
            var listeningElement = parentElement.querySelector('.listening');
            var receivedElement = parentElement.querySelector('.received');

            listeningElement.setAttribute('style', 'display:none;');
            receivedElement.setAttribute('style', 'display:block;');

            console.log('Received Event: ' + id);

            // start to initialize PayPalMobile library
            app.initPaymentUI();
        },
        initPaymentUI : function () {
          var clientIDs = {
            "PayPalEnvironmentProduction": payPalEnvironmentProduction,
            "PayPalEnvironmentSandbox": payPalEnvironmentSandbox
          };
          PayPalMobile.init(clientIDs, app.onPayPalMobileInit);

        },
        onSuccesfulPayment : function(payment) {
          onSuccesfulPayment(payment);
        },
        // This code is only used for independent card.io scanning abilities
        onCardIOComplete: function(card) {
          console.log("Card Scanned success: " + JSON.stringify(card, null, 4));
        },
        onAuthorizationCallback : function(authorization) {
          console.log("authorization: " + JSON.stringify(authorization, null, 4));
        },
        createPayment : function () {
          // for simplicity use predefined amount
          // optional payment details for more information check [helper js file](https://github.com/paypal/PayPal-Cordova-Plugin/blob/master/www/paypal-mobile-js-helper.js)
          var paymentDetails = new PayPalPaymentDetails("50.00", "0.00", "0.00");
          var payment = new PayPalPayment("50.00", "USD", "Awesome Sauce", "Sale", paymentDetails);
          return payment;
        },
        configuration : function () {
          // for more options see `paypal-mobile-js-helper.js`
          var config = new PayPalConfiguration({merchantName: "My test shop", merchantPrivacyPolicyURL: "https://mytestshop.com/policy", merchantUserAgreementURL: "https://mytestshop.com/agreement"});
          return config;
        },
        onPrepareRender : function() {
          // buttons defined in index.html
          //  <button id="buyNowBtn"> Buy Now !</button>
          //  <button id="buyInFutureBtn"> Pay in Future !</button>
          //  <button id="profileSharingBtn"> ProfileSharing !</button>
          //  <button id="cardScanBtn">Advanced: Use card.io scan only</button>
          var buyNowBtn = document.getElementById("buyNowBtn");
          var buyInFutureBtn = document.getElementById("buyInFutureBtn");
          var profileSharingBtn = document.getElementById("profileSharingBtn");
          var cardScanBtn = document.getElementById("cardScanBtn");

          buyNowBtn.onclick = function(e) {
            // single payment
            PayPalMobile.renderSinglePaymentUI(app.createPayment(), app.onSuccesfulPayment, app.onUserCanceled);
          };

          buyInFutureBtn.onclick = function(e) {
            // future payment
            PayPalMobile.renderFuturePaymentUI(app.onAuthorizationCallback, app.onUserCanceled);
          };

          profileSharingBtn.onclick = function(e) {
            // profile sharing
            PayPalMobile.renderProfileSharingUI(["profile", "email", "phone", "address", "futurepayments", "paypalattributes"], app.onAuthorizationCallback, app.onUserCanceled);
          };
          
          cardScanBtn.onclick = function(e) {
            // card.io scanning independent of paypal payments. 
            // This is used for cases where you only need to scan credit cards and not use PayPal as funding option.
            CardIO.scan({
                        "requireExpiry": true,
                        "requireCVV": false,
                        "requirePostalCode": false,
                        "restrictPostalCodeToNumericOnly": true
                      },
                      app.onCardIOComplete,
                      app.onUserCanceled
                    );
          };
        },
        onPayPalMobileInit : function() {
          // must be called
          // use PayPalEnvironmentNoNetwork mode to get look and feel of the flow
          PayPalMobile.prepareToRender("PayPalEnvironmentSandbox", app.configuration(), app.onPrepareRender);
        },
        onUserCanceled : function(result) {
          console.log(result);
        }

    };
    
    return myPaypalApp;
  };


  /**
   * @type function
   * @name device ready
   * @description {{functionToPaypalApp}}
   * @multilayer false 
   * param {ObjectType.STRING} onDeviceReady
   * param {ObjectType.STRING} bindEvents    
   * @returns {ObjectType.OBJECT}
   */
  this.cronapi.paypal.devicereadyPaypalApp = function() {
    var myPaypalApp = {       
          // Application Constructor
        initialize: function() {
            this.bindEvents();
        },
        // Bind Event Listeners
        //
        // Bind any events that are required on startup. Common events are:
        // 'load', 'deviceready', 'offline', and 'online'.
        bindEvents: function() {
            document.addEventListener('deviceready', this.onDeviceReady, false);
        },
        // deviceready Event Handler
        //
        // The scope of 'this' is the event. In order to call the 'receivedEvent'
        // function, we must explicity call 'app.receivedEvent(...);'
        onDeviceReady: function() {
            myPaypalApp.receivedEvent('deviceready');
        },
        // Update DOM on a Received Event
        receivedEvent: function(id) {
            console.log('Received Event: ');
            var parentElement = document.getElementById(id);
            var listeningElement = parentElement.querySelector('.listening');
            var receivedElement = parentElement.querySelector('.received');

            listeningElement.setAttribute('style', 'display:none;');
            receivedElement.setAttribute('style', 'display:block;');

            console.log('Received Event: ' + id);

            // start to initialize PayPalMobile library
            myPaypalApp.initPaymentUI();            
        },
        initPaymentUI : function () {
      var clientIDs = {
        
        "PayPalEnvironmentSandbox": "Af4MU2E77LH2BbHa2Ep0H0L-_vXnFvD6qKGKZekj7b_cCMbKWJrz9dASuQ4eL0ObCN2cq377v7DDxNyG"
      };
      PayPalMobile.init(clientIDs, myPaypalApp.onPayPalMobileInit);

    },
    onSuccesfulPayment : function(payment) {
      console.log("payment success: " + JSON.stringify(payment, null, 4));
    },
    onPayPalMobileInit : function() {
          // must be called
          // use PayPalEnvironmentNoNetwork mode to get look and feel of the flow
          PayPalMobile.prepareToRender("PayPalEnvironmentSandbox", app.configuration(), app.onPrepareRender);
        },
        onUserCanceled : function(result) {
          console.log(result);
        }
    }
   return myPaypalApp;
		};

   
   
   
  
  /**
   * @type function
   * @name initializePaypalApp
   * @description initializePaypalApp
   * @multilayer false
   * @param {ObjectType.OBJECT} input Param Description
   */
  this.cronapi.paypal.initializePaypalApp = function(/** @type {ObjectType.OBJECT}*/myPaypalApp) {
    myPaypalApp.initialize();
  };

}).bind(window)();