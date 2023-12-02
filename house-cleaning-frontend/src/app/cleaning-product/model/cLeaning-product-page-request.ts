import {PageRequest} from "../../core/model/page-request";

export interface CLeaningProductPageRequest extends PageRequest {
  productName: string;
}
