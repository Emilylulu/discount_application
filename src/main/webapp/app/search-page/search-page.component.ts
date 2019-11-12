import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'jhi-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {
  private routeSub: Subscription;
  searchKey;

  constructor(private router: ActivatedRoute) {}

  ngOnInit() {
    //let searchKey;

    this.routeSub = this.router.params.subscribe(params => {
      //console.log(params); //log the entire params object
      //console.log(params['id']); //log the value of id
      this.searchKey = params['searchKey'];
    });

    //add elasticsearch part for searhcing with searchKey
  }
}
