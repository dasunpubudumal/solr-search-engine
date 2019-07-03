import { Component, OnInit } from '@angular/core';
import {SolarService} from "../../services/solar.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchString: string;
  results: any;
  displayedColumns: string[] = ['artist', 'author', 'lyrics', 'title'];
  expandedElement: PeriodicElement | null;

  constructor(protected solarService: SolarService) {
    this.searchString = "";
  }

  ngOnInit() {
  }

  public _get() {
    this.solarService.get(this.searchString).subscribe((result) => {
      this.results = result;
      console.log(result);
    })
  }

}

export interface PeriodicElement {
  artist: string;
  author: number;
  lyrics: number;
  title: string;
}
