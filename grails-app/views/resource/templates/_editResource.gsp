<div class="form-group editResource" style="padding-bottom:25px" data-id="editResource${resource.id}">
    <div class="col-xs-5">
        <textarea placeholder="Resource Description" class="form-control"
               id="resourceEditBox${resource.id}" value="${resource.description}"></textarea>
    </div>

    <div class="col-xs-2">
        <button type="button" class="btn btn-success buttonSaveResource" data-id="${resource.id}"
                id="resourcesaveButton${resource.id}" data-url="${g.createLink(controller: 'resource',action: 'updateResourceDescription')}">Save</button>
    </div>

    <div class="col-xs-2">
        <button type="button" class="btn btn-danger buttonCancelResource" data-id="${resource.id}"
                id="resourceCancelButton${resource.id}">Cancel</button>
    </div>
</div>