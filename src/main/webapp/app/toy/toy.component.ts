import { Component, OnInit } from '@angular/core';
import endpoints from 'app/shared/constants/endpoint';
import { Router } from '@angular/router';
import axios from 'axios';

@Component({
  selector: 'jhi-toy',
  templateUrl: './toy.component.html',
  styleUrls: ['./toy.component.scss']
})
export class ToyComponent implements OnInit {
  toyChunks;
  constructor(private router: Router) {}

  async ngOnInit() {
    try {
      const data = await axios.get(endpoints.ALL_TOYS);
      this.toyChunks = this.chunks(data.data, 4);
      //console.table(this.toyChunks);
    } catch (e) {
      // TODO handle get data fail later
      //console.table(`Error connecting with server: ${e}`);
    }
  }
  onSelect(toy) {
    this.router.navigate(['/item', toy.id]);
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
