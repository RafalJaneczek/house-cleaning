import {Component, OnInit} from '@angular/core';
import {CleaningService} from '../service/cleaning.service';
import {CleaningResponse} from '../model/cleaning-response';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../user/service/user.service';
import {UserResponse} from '../../user/model/user-response';
import {CleaningRequest} from '../model/cleaning-request';
import {MatTableDataSource} from '@angular/material/table';
import {PageRequest} from '../../core/model/page-request';
import {DictionaryEntryResponse} from '../../core/model/dictionary-entry-response';
import {DictionaryService} from '../../core/service/dictionary.service';
import {Router} from "@angular/router";


@Component({
  selector: 'app-cleaning',
  templateUrl: './cleaning.component.html',
  styleUrls: ['./cleaning.component.sass']
})
export class CleaningComponent implements OnInit {

  protected cleaningForm: FormGroup;
  protected submitted: boolean = false;
  protected users: UserResponse[] = [];
  protected roomDictionaries: DictionaryEntryResponse[] = [];
  protected allCleanings: CleaningResponse[] = [];

  protected cleaningTableColumns: string[] = ['index', 'firstName', 'roomName', 'cleaningDate'];
  protected statisticsTableColumns: string[] = ['firstName', 'kitchen', 'bathroom'];
  protected cleaningData: MatTableDataSource<CleaningResponse>;

  protected totalItems: number;
  protected pageSize: number = 5;
  protected pageNumber: number = 0;
  protected pageSizeOptions: number[] = [5, 10, 25, 50];

  protected requestInProgress: boolean = false;

  constructor(private cleaningService: CleaningService,
              private formBuilder: FormBuilder,
              private userService: UserService,
              private dictionaryService: DictionaryService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.createCleaningForm();
    this.getAllUsers();
    this.getRoomDictionaryEntries();
    this.getAllCleanings({pageSize: 5, pageNumber: 0, sort: 'cleaningDate'});
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.cleaningForm.invalid) {
      return;
    }

    const request: CleaningRequest = this.getCleaningRequest();
    this.saveCleaning(request);
  }

  getStatistics(userId: number, room: string): number {
    return this.allCleanings.filter(cleaning => cleaning.roomName === room && cleaning.user.id === userId).length;
  }

  onPageChange(event: any): void {
    this.pageSize = event.pageSize;
    this.pageNumber = event.pageNumber;

    const pageRequest: PageRequest = {
      pageSize: event.pageSize,
      pageNumber: event.pageIndex,
      sort: 'cleaningDate'
    }

    this.getAllCleanings(pageRequest);
  }

  private getRoomDictionaryEntries(): void {
    this.dictionaryService.getAllDictionaries().subscribe(dictionaryEntry => {
      this.roomDictionaries = dictionaryEntry.filter(entry => entry.dictionaryName === 'rooms');
    })
  }

  private getAllUsers(): void {
    this.userService.getAllUsers().subscribe(users => {
      this.users = users;
    });
  }

  private saveCleaning(request: CleaningRequest): void {
    this.requestInProgress = true;
    this.cleaningService.saveCleaning(request).subscribe(response => {
      this.totalItems = response.totalItems;
      this.allCleanings = response.fullContent;
      this.cleaningData = new MatTableDataSource<CleaningResponse>(response.content)
      this.cleaningForm.reset();
      this.submitted = false;
      this.requestInProgress = false;
    });
  }

  private getAllCleanings(request: PageRequest): void {
    this.requestInProgress = true;
    this.cleaningService.getAllCleanings(request).subscribe(response => {
      this.totalItems = response.totalItems;
      this.allCleanings = response.fullContent;
      this.cleaningData = new MatTableDataSource<CleaningResponse>(response.content);
      this.requestInProgress = false;
    })
  }

  private getCleaningRequest(): CleaningRequest {
    return {
      userId: this.cleaningForm.get('user').value,
      roomName: this.cleaningForm.get('roomName').value,
      pageNumber: this.pageNumber,
      pageSize: this.pageSize,
      sort: 'cleaningDate'
    };
  }

  private createCleaningForm(): void {
    this.cleaningForm = this.formBuilder.group({
      user: ['', Validators.required],
      roomName: ['', Validators.required]
    })
  }

  goToDashboard(): void {
    this.router.navigate(['/'])
  }
}
