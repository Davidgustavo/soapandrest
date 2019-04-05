window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Paypal = window.blockly.js.blockly.Paypal || {};

/**
 * paypal
 */
window.blockly.js.blockly.Paypal.Executar = function() {

  this.cronapi.screen.notify('success','sucesso');
  this.cronapi.util.executeJavascriptNoReturn('paypal.Buttons().render(\'body\')\n\npaypal.Buttons({\n    createOrder: function(data, actions) {\n      return actions.order.create({\n        purchase_units: [{\n          amount: {\n            val' +
   'ue: \'0.01\'\n          }\n        }]\n      });\n    },\n    onApprove: function(data, actions) {\n      // Capture the funds from the transaction\n      return actions.order.capture().then(function(' +
   'details) {\n        // Show a success message to your buyer\n        alert(\'Transaction completed by \' + details.payer.name.given_name);\n      });\n    }\n  }).render(\'#paypal-button-container\');');
}
