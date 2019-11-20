import { Component, OnInit } from '@angular/core';
import endpoints from '../shared/constants/endpoint';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import axios from 'axios';
import ItemDetail from 'app/item/model/item';

import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

@Component({
  selector: 'jhi-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss'],
  providers: [NgbRatingConfig] // add NgbRatingConfig to the component providers
})
export class ItemComponent implements OnInit {
  list: Array<ItemDetail>;
  reviewList;
  showNavigationArrows = false;
  showNavigationIndicators = false;
  images = [1, 2, 3].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`);
  page = 1;
  pageSize = 3;
  contentSize;
  results = [];
  originalPrice;
  descriptonList = [];
  totalDes = [];
  ratingScore;
  productAddr;
  simiList;
  index = 0;

  private routeSub: Subscription;
  constructor(
    private router: ActivatedRoute,
    private config: NgbRatingConfig,
    private carouse: NgbCarouselConfig,
    private router2: Router
  ) {
    this.list = [];
    config.max = 5;
    config.readonly = true;
    carouse.showNavigationArrows = true;
    carouse.showNavigationIndicators = true;
  }

  async ngOnInit() {
    let id;
    let score;

    this.routeSub = this.router.params.subscribe(params => {
      console.log(params); //log the entire params object
      console.log(params['id']); //log the value of id
      id = params['id'];
      //id = +params['id'];

      //this.onSelect(id);
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
    this.originalPrice = (parseFloat(this.list['price']) + Math.random() * 10).toFixed(2);
    this.descriptonList = this.list['description'].split('.', 2).filter(Boolean);
    this.totalDes = this.list['description'].split('.').filter(Boolean);

    try {
      const review = await axios.get(endpoints.REVIEW + id);
      this.reviewList = this.chunks(review.data, 1);

      //this.contentSize = this.reviewList.size;
      // this.reviewList = await axios.get(endpoints.REVIEW + id).then(function (response) {
      //   return response.data;
      //
      // });
    } catch (e) {
      // TODO handle get data fail later
      console.table(`Error connecting with server: ${e}`);
    }
    this.contentSize = this.results.length;

    try {
      this.ratingScore = await axios.get(endpoints.RATING + id).then(function(response) {
        return response.data;
      });
      //this.ratingScore = 5;
    } catch (e) {
      // TODO handle get data fail later
      //console.table(`Error connecting with server: ${e}`);
      console.log('error');
    }
    try {
      const similar = await axios.get(endpoints.SIMITEMS + id);
      this.simiList = this.chunks(similar.data, 4);

      //this.contentSize = this.reviewList.size;
      // this.reviewList = await axios.get(endpoints.REVIEW + id).then(function (response) {
      //   return response.data;
      //
      // });
    } catch (e) {
      // TODO handle get data fail later
      console.table(`Error connecting with server: ${e}`);
    }
    //this.ratingScore = 3;
  }
  onClick() {
    window.location.href = 'https://www.amazon.com/s?k=' + this.list['id'] + '&nb_sb_noss';
  }

  onSelect(sitem) {
    this.router2.navigate(['/item', sitem.id]);
  }

  chunks = (array, size) => {
    if (array === undefined) {
      return array;
    }
    // const results = [];
    while (array.length) {
      this.results.push(array.splice(0, size));
    }
    return this.results;
  };
}
