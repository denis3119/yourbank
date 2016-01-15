<div class="modal-header">
    <h3 class="modal-title">Deposit</h3>
</div>

<div class="modal-body">
    <form class="form-horizontal" name="editProfileForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">Value</label>
            <div class="col-md-5">
                <input class="form-control" required type="email" ng-model="deposit.value">
            </div>
        </div>
    </form>
</div>

<div class="modal-footer">
    <button class="btn btn-danger" type="button" ng-click="$dismiss()">Cancel</button>
    <button class="btn btn-primary" type="button" ng-click="$close(user)">Save</button>
</div>