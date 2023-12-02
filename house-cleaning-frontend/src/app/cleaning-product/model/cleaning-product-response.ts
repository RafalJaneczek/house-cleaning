import {UserResponse} from "../../user/model/user-response";

export interface CleaningProductResponse {
  id: number;
  dateOfPurchase: Date;
  productName: string;
  user: UserResponse;
}
