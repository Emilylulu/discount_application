import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'jhi-footer',
  templateUrl: './footer.component.html'
})
export class FooterComponent implements OnInit {
  searchKey: string;

  constructor(private router: Router) {}
  ngOnInit(): void {}

  searchRequest(searchKey) {
    this.router.navigate(['./search', this.searchKey]);
  }
}
