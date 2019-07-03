import { Component, OnInit } from '@angular/core';
import {SolarService} from "../../services/solar.service";
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})

export class SearchComponent implements OnInit {

  searchString: string;
  results: any;
  displayedColumns: string[] = ['artist', 'author', 'lyrics', 'title', 'score'];
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
  score: string;
}
