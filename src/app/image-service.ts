import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

    dataUrl = 'http://localhost:8080/resources';

    private getUrlForImageWithId(id: string) {
        return `${this.dataUrl}/images/${id}`;
    }

    private async getHotelImageIds(hotelId: number) {
        const res = await fetch(`${this.dataUrl}/hotel-${hotelId.toString()}/images`);
        if (res.ok) { const imageIds = res.text().then(
                body => { return body.split("&"); }
            );
            return imageIds;
        }
        else return [];
    }

    async getHotelImagesUrls(hotelId: number) {
        const imageIds = await this.getHotelImageIds(hotelId);
        const urls: string[] = imageIds.map(id => this.getUrlForImageWithId(id));
        return urls;
    }
}