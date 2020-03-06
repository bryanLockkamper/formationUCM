import { ResourceDetail } from './resource-detail';

export interface UserResource {
    id: number;
    pseudo: string;
    resource: ResourceDetail[];
}