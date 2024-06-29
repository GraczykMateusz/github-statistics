export class ApiBuilder {
  
  private constructor(private url: string) {
  }
  
  static get api(): ApiBuilder {
    return new ApiBuilder('api');
  }
  
  get v1(): ApiBuilder {
    return this.append('v1');
  }
  
  users(login: string): ApiBuilder {
    return this.append(`users`).append(login);
  }
  
  get statistics(): ApiBuilder {
    return this.append(`statistics`);
  }
  
  build(): string {
    return this.url;
  }
  
  private append(value: string): ApiBuilder {
    this.url += `/${value}`;
    return this;
  }
}
