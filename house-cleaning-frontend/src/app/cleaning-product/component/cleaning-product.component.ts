import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DictionaryEntryResponse} from '../../core/model/dictionary-entry-response';
import {UserService} from '../../user/service/user.service';
import {CleaningProductService} from '../service/cleaning-product.service';
import {UserResponse} from '../../user/model/user-response';
import {DictionaryService} from '../../core/service/dictionary.service';
import {CleaningProductResponse} from '../model/cleaning-product-response';
import {MatTableDataSource} from '@angular/material/table';
import {CLeaningProductPageRequest} from '../model/cLeaning-product-page-request';
import {CleaningProductRequest} from '../model/cleaning-product-request';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cleaning-product',
  templateUrl: './cleaning-product.component.html',
  styleUrls: ['./cleaning-product.component.sass']
})
export class CleaningProductComponent implements OnInit {

  protected cleaningProductForm: FormGroup;
  protected productDictionaries: DictionaryEntryResponse[] = [];
  protected users: UserResponse[] = [];
  protected submitted: boolean;
  protected allCLeaningProducts: CleaningProductResponse[] = [];

  protected cleaningProductsTableColumns: string[] = ['index', 'userFirstName', 'productName', 'dateOfPurchase'];
  protected statisticsTableColumns: string[] = [];
  protected cleaningProductData: MatTableDataSource<CleaningProductResponse>;

  protected productName: string = 'toiletPaper';
  protected totalItems: number;
  protected pageSize: number = 5;
  protected pageNumber: number = 0;
  protected pageSizeOptions: number[] = [5, 10, 25, 50];
  protected tabIndex: number;
  protected requestInProgress: boolean = false;
  protected saveRequestInProgress: boolean = false;

  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
              private dictionaryService: DictionaryService,
              private cleaningProductService: CleaningProductService,
              private router: Router) {
  }

  ngOnInit() {
    this.createCleaningForm();
    this.getCleaningProductDictionaryEntries();
    this.getAllUsers();
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.cleaningProductForm.invalid) {
      return;
    }

    const request: CleaningProductRequest = {
      userId: this.cleaningProductForm.get('user').value,
      productName: this.cleaningProductForm.get('productName').value,
      pageNumber: this.pageNumber,
      pageSize: this.pageSize,
      sort: 'dateOfPurchase'
    };

    this.saveCleaningProduct(request);
  }

  getStatistics(userId: number, productName: string): number {
    return this.allCLeaningProducts.filter(product => product.productName === productName && product.user.id === userId).length;
  }

  saveCleaningProduct(request: CleaningProductRequest): void {
    this.saveRequestInProgress = true;
    this.cleaningProductService.saveProduct(request).subscribe(response => {
      this.productName = request.productName;
      this.cleaningProductForm.reset();
      this.submitted = false;
      this.statisticsTableColumns = ['firstName', this.productName];
      this.tabIndex = this.productDictionaries.indexOf(this.productDictionaries.find(product => product.key === request.productName));
      this.saveRequestInProgress = false;
    })
  }

  onPageChange(event: any): void {
    this.pageSize = event.pageSize;
    this.pageNumber = event.pageNumber;

    const pageRequest: CLeaningProductPageRequest = {
      productName: this.productName,
      pageSize: event.pageSize,
      pageNumber: event.pageIndex,
      sort: 'dateOfPurchase'
    }

    this.getAllCleaningProducts(pageRequest);
  }

  clickOnTab(event: any): void {
    const dictionaryEntryResponse: DictionaryEntryResponse = this.productDictionaries[event.index];
    this.getAllCleaningProducts({
      productName: dictionaryEntryResponse.key,
      pageSize: 5,
      pageNumber: 0,
      sort: 'dateOfPurchase'
    })
  }

  goToDashboard(): void {
    this.router.navigate(['/'])
  }

  private getAllCleaningProducts(request: CLeaningProductPageRequest): void {
    this.requestInProgress = true;
    this.cleaningProductService.getAllProducts(request).subscribe(response => {
      this.productName = request.productName;
      this.totalItems = response.totalItems;
      this.allCLeaningProducts = response.fullContent;
      this.cleaningProductData = new MatTableDataSource<CleaningProductResponse>(response.content);
      this.requestInProgress = false;
      this.statisticsTableColumns = ['firstName', this.productName];
    })
  }

  private getCleaningProductDictionaryEntries(): void {
    this.dictionaryService.getAllDictionaries().subscribe(dictionaryEntry => {
      this.productDictionaries = dictionaryEntry.filter(entry => entry.dictionaryName === 'cleaningProducts');
    })
  }

  private getAllUsers(): void {
    this.userService.getAllUsers().subscribe(users => {
      this.users = users;
    });
  }

  private createCleaningForm(): void {
    this.cleaningProductForm = this.formBuilder.group({
      user: ['', Validators.required],
      productName: ['', Validators.required]
    })
  }

}
