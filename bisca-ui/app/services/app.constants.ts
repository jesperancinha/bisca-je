export class Configuration {
    public Server: string = 'http://localhost:5000/';
    public ApiUrl: string = '';
    public ServerWithApiUrl = this.Server + this.ApiUrl;
}