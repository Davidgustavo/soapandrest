window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PayPalMob = window.blockly.js.blockly.PayPalMob || {};

/**
 * PayPalMob
 */
window.blockly.js.blockly.PayPalMob.Executar = function() {
 var item, id, objeto;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.PayPal:paypal', function(sender_item) {
      item = sender_item;
    objeto = this.cronapi.json.createObjectFromString(item);
    id = this.cronapi.json.getProperty(objeto, 'id');
    this.cronapi.screen.notify('success',id);
  }.bind(this));
}
