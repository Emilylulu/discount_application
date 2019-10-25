import { Component, OnInit } from '@angular/core';
import axios from 'axios';

import { Router } from '@angular/router';
import endpoints from '../shared/constants/endpoint';

@Component({
  selector: 'jhi-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {
  gameChunks;
  constructor(private router: Router) {}

  async ngOnInit() {
    try {
      const data = await axios.get(endpoints.ALL_GAMES);
      this.gameChunks = this.chunks(data.data, 4);
      // console.table(this.gameChunks);
    } catch (e) {
      // TODO handle get data fail later
      // console.table(`Error connecting with server: ${e}`);
    }
  }
  onSelect(game) {
    this.router.navigate(['/item', game.id]);
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
