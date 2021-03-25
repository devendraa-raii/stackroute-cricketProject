import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { FetchService } from './fetch.service';

import { RecordService } from './record.service';

describe('RecordService', () => {
  let service: RecordService;
  let http:HttpClient;
  let fetch:FetchService;
  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecordService);
    http=TestBed.inject(HttpClient);
    fetch=TestBed.inject(FetchService);
  });

  // it('should be created', () => {
  //   expect(service).toBeTruthy();
  // });
});
