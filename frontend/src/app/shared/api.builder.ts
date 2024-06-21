export class ApiBuilder {
  
  private constructor(private url: string) {
  }
  
  static get api() {
    return new ApiBuilder('api');
  }
  
  get v1() {
    return this.append('v1');
  }
  
  users(login: string) {
    return this.append(`users`).append(login);
  }
  
  build(): string {
    return this.url;
  }
  
  private append(value: string) {
    this.url += `/${value}`;
    return this;
  }
}
