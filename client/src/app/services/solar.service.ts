import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class SolarService {

  constructor(protected http: HttpClient) { }

  public get(searchTerm: string) {
    return this.http.get<any[]>("/api/query?term=".concat(searchTerm))
      .pipe(
        map(results => results)
      );
  }
}
