window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Bloco = window.blockly.js.blockly.Bloco || {};

/**
 * Bloco
 */
window.blockly.js.blockly.Bloco.Executar = function() {
 var item;
  this.cronapi.cordova.camera.getPicture(function(sender_item) {
      item = sender_item;
  }.bind(this), function(sender_item) {
      item = sender_item;
  }.bind(this), '0', '0', '0', 'false');
}
