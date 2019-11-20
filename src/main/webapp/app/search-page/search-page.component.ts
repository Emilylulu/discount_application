import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import endpoints from 'app/shared/constants/endpoint';
import axios from 'axios';
import { Router } from '@angular/router';

@Component({
  selector: 'jhi-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {
  private routeSub: Subscription;
  //searchKey;
  searchChunks;

  constructor(private router: ActivatedRoute, private router2: Router) {}

  async ngOnInit() {
    let searchKey;

    this.routeSub = this.router.params.subscribe(params => {
      //console.log(params); //log the entire params object
      //console.log(params['id']); //log the value of id
      searchKey = params['searchKey'];
    });

    try {
      const data = await axios.get(endpoints.SEARCH + searchKey);
      this.searchChunks = this.chunks(data.data, 4);
    } catch (e) {
      // TODO handle get data fail later
      //console.table(`Error connecting with server: ${e}`);
      console.log('error');
    }

    //add elasticsearch part for searhcing with searchKey
  }

  onSelect(searchRes) {
    this.router2.navigate(['/item', searchRes.id]);
  }

  chunks = (array, size) => {
    if (array === undefined) {
      return array;
    }
    const results = [];
    while (array.length) {
      results.push(array.splice(0, size));
    }
    return results;
  };
}
