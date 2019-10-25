import { Component, OnInit } from '@angular/core';
import endpoints from '../shared/constants/endpoint';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import axios from 'axios';
import ItemDetail from 'app/item/model/item';

@Component({
  selector: 'jhi-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {
  list: Array<ItemDetail>;
  reviewList;

  private routeSub: Subscription;
  constructor(private router: ActivatedRoute) {
    this.list = [];
  }

  async ngOnInit() {
    let id;

    this.routeSub = this.router.params.subscribe(params => {
      console.log(params); //log the entire params object
      console.log(params['id']); //log the value of id
      id = params['id'];
    });

    try {
      this.list = await axios.get(endpoints.ONE_ITEM + id).then(function(response) {
        return response.data;
      });
    } catch (e) {
      // TODO handle get data fail later
      //console.table(`Error connecting with server: ${e}`);
      console.log('error');
    }

    // try {
    //
    //
    //
    //   const review = await axios.get(endpoints.REVIEW + id);
    //   this.reviewList = this.chunks(review.data, 20);
    //
    // } catch (e) {
    //   // TODO handle get data fail later
    //   console.table(`Error connecting with server: ${e}`);
    // }
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
