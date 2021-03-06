<div class="modal fade" id="createTopic" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="background-color:#D3D3D3">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>

            <div class="modal-body">
                <g:form controller="topic" action="save" class="form-horizontal">

                    <div class="form-group">

                        <label for="inputName" class="control-label col-xs-2">Name*</label>

                        <div class="col-xs-10">

                            <input type="text" class="form-control" name="name" id="inputName" placeholder="topic name here">

                        </div>

                    </div>

                    <div class="form-group">

                        <label for="visibility" class="control-label col-xs-2">Visibility*</label>

                        <div class="col-xs-10">

                            <g:select class="form-control"  id="visibility" name="visibility" from="${com.tothenew.linkshare.topic.Visibility.values()}">
                            </g:select>

                        </div>

                    </div>


                    <div class="form-group">

                        <div class="col-xs-offset-2 col-xs-10">

                            <g:submitButton name="submit" type="submit" class="btn btn-primary">Save</g:submitButton>
                            <button class="btn btn-default" data-dismiss="modal">Cancel</button>

                        </div>

                    </div>

                </g:form>
            </div>

        </div>
    </div>
</div>