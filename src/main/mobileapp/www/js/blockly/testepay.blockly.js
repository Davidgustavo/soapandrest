window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Testepay = window.blockly.js.blockly.Testepay || {};

/**
 * testepay
 */
window.blockly.js.blockly.Testepay.Executar = function() {
 var item;
  this.cronapi.paypal.initializePaypalApp(this.cronapi.paypal.devicereadyPaypalApp());
}
