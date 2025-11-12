import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MallAdminService } from './MallAdmin.service';

describe('MallAdminService', () => {
  let service: MallAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [MallAdminService],
    });
    service = TestBed.inject(MallAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
