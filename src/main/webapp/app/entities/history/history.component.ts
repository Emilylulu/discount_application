import { Component, OnInit } from '@angular/core';
import axios from 'axios';
import endpoints from 'app/shared/constants/endpoint';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { JhiEventManager } from 'ng-jhipster';
import { Subscription } from 'rxjs';
import { Account } from 'app/core/user/account.model';
import { AccountService } from 'app/core/auth/account.service';

@Component({
  selector: 'jhi-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.scss']
})
export class HistoryComponent implements OnInit {
  historyChunks;
  account: Account;
  authSubscription: Subscription;

  constructor(
    private router: Router,
    private actRouter: ActivatedRoute,
    private accountService: AccountService,
    private eventManager: JhiEventManager
  ) {}

  async ngOnInit() {
    this.accountService.identity().subscribe((account: Account) => {
      this.account = account;
    });
    this.registerAuthenticationSuccess();
    try {
      const data = await axios.get(endpoints.History, { withCredentials: true });

      console.table(data.data);
      this.historyChunks = this.chunks(data.data, 4);
    } catch (e) {
      // TODO handle get data fail later
      //console.log(`Error connecting with server: ${e}`);
    }
  }
  registerAuthenticationSuccess() {
    this.authSubscription = this.eventManager.subscribe('authenticationSuccess', message => {
      this.accountService.identity().subscribe(account => {
        this.account = account;
      });
    });
  }

  onSelect(item) {
    this.router.navigate(['/item', item.id]);
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
