window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PayPalMob = window.blockly.js.blockly.PayPalMob || {};

/**
 * PayPalMob
 */
window.blockly.js.blockly.PayPalMob.Executar = function() {
 var id, item, rel, i, href, objeto, status, objetoserv;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.PayPal:paypal', function(sender_objetoserv) {
      objetoserv = sender_objetoserv;
    objeto = this.cronapi.json.createObjectFromString(objetoserv);
    id = this.cronapi.json.getProperty(objeto, 'id');
    this.cronapi.screen.changeValueOfField("vars.pay_id", id);
    status2 = this.cronapi.json.getProperty(objeto, 'status');
    this.cronapi.screen.changeValueOfField("vars.status", status2);
    this.cronapi.screen.notify('warning',id);
    objeto = this.cronapi.json.getProperty(objeto, 'links');
    for (var i_index in objeto) {
      i = objeto[i_index];
      href = this.cronapi.json.getProperty(i, 'href');
      this.cronapi.screen.notify('success',href);
      rel = this.cronapi.json.getProperty(i, 'rel');
      this.cronapi.screen.notify('success',rel);
    }
  }.bind(this));
}
