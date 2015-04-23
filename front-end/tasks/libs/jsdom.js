import { jsdom } from 'jsdom';

global.document = jsdom('<html><body></body></html>', {
  parsingMode: 'html'
});
global.window = global.document.parentWindow;
global.navigator = window.navigator || {};
