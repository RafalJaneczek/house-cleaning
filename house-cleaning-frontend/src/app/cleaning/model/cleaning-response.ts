import {UserResponse} from '../../user/model/user-response';

export interface CleaningResponse {
  id: number;
  cleaningDate: Date;
  roomName: string;
  user: UserResponse;
}
