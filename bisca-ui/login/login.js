"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('angular2/core');
var router_1 = require('angular2/router');
var common_1 = require('angular2/common');
var http_1 = require('angular2/http');
var headers_1 = require('../common/headers');
var styles = require('./login.css');
var template = require('./login.html');
var Login = (function () {
    function Login(router, http) {
        this.router = router;
        this.http = http;
    }
    Login.prototype.login = function (event, username, password) {
        var _this = this;
        event.preventDefault();
        var body = JSON.stringify({ username: username, password: password });
        this.http.post('http://localhost:3001/sessions/create', body, { headers: headers_1.contentHeaders })
            .subscribe(function (response) {
            localStorage.setItem('jwt', response.json().id_token);
            _this.router.parent.navigateByUrl('/home');
        }, function (error) {
            alert(error.text());
            console.log(error.text());
        });
    };
    Login.prototype.signup = function (event) {
        event.preventDefault();
        this.router.parent.navigateByUrl('/signup');
    };
    Login = __decorate([
        core_1.Component({
            selector: 'login',
            directives: [router_1.RouterLink, common_1.CORE_DIRECTIVES, common_1.FORM_DIRECTIVES],
            template: template,
            styles: [styles]
        }), 
        __metadata('design:paramtypes', [router_1.Router, http_1.Http])
    ], Login);
    return Login;
}());
exports.Login = Login;
//# sourceMappingURL=login.js.map