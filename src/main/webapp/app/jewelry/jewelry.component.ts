import { Component, OnInit } from '@angular/core';
import endpoints from 'app/shared/constants/endpoint';
import axios from 'axios';
import { Router } from '@angular/router';

@Component({
  selector: 'jhi-jewelry',
  templateUrl: './jewelry.component.html',
  styleUrls: ['./jewelry.component.scss']
})
export class JewelryComponent implements OnInit {
  jewelryChunks;
  constructor(private router: Router) {}

  async ngOnInit() {
    try {
      const data = await axios.get(endpoints.ALL_JEWELRY);
      this.jewelryChunks = this.chunks(data.data, 4);
      //console.table(this.jewelryChunks);
    } catch (e) {
      // TODO handle get data fail later
      //console.table(`Error connecting with server: ${e}`);
    }
  }
  onSelect(jewelry) {
    this.router.navigate(['/item', jewelry.id]);
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
