import {PageRequest} from '../../core/model/page-request';

export interface CleaningProductRequest extends PageRequest {
  userId: number;
  productName: string;
}
