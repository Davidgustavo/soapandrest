(function() {
  'use strict';

  this.cronapi = this.cronapi || {};

  /**
   * @category PAYPALBRAINTREE
   * @categoryTags PaypalBrainTree|PaypalBrainTree
   */
  this.cronapi.paypalbraintree = {};
  
  /**
   * @type function
   * @name Create Brain Tree
   * @description Descrição da Função
   * @multilayer false
   * @param {ObjectType.STRING} input Param Description
   * @returns {ObjectType.STRING}
   */
  this.cronapi.paypalbraintree.CreatePayPalBrainTree = function(/** @type {ObjectType.STRING} @description Parâmetro: Descrição do parâmetro */input) {
    // Create a client.
braintree.client.create({
  authorization: CLIENT_AUTHORIZATION
}).then(function (clientInstance) {
  // Create a PayPal Checkout component.
  return braintree.paypalCheckout.create({
    client: clientInstance
  });
}).then(function (paypalCheckoutInstance) {
  // Set up PayPal with the checkout.js library
  return paypal.Button.render({
    env: 'production', // or 'sandbox'

    payment: function () {
      return paypalCheckoutInstance.createPayment({
        // Your PayPal options here. For available options, see
        // http://braintree.github.io/braintree-web/current/PayPalCheckout.html#createPayment
      });
    },

    onAuthorize: function (data, actions) {
      return paypalCheckoutInstance.tokenizePayment(data)
        .then(function (payload) {
          // Submit `payload.nonce` to your server.
        });
    },

    onCancel: function (data) {
      console.log('checkout.js payment cancelled', JSON.stringify(data, 0, 2));
    },

    onError: function (err) {
      console.error('checkout.js error', err);
    }
  }, '#paypal-button');
}).then(function () {
  // The PayPal button will be rendered in an html element with the id
  // `paypal-button`. This function will be called when the PayPal button
  // is set up and ready to be used.
}).catch(function (err) {
  // Handle component creation error
});
    return "INPUT" + input;
  };
  

}).bind(window)();