window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Authfacebook = window.blockly.js.blockly.Authfacebook || {};

/**
 * authfacebook
 */
window.blockly.js.blockly.Authfacebook.Executar = function() {

  this.cronapi.screen.notify('success','Sucesso');
  this.cronapi.social.sociaLogin('facebook');
}
