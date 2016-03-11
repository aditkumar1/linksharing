<div class="modal fade" id="linkShare" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="background-color:#D3D3D3">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Link</h4>
            </div>

            <div class="modal-body">
                <g:form controller="linkResource" action="save" class="form-horizontal">
                    <div class="form-group">
                        <label for="inputLink" class="control-label col-xs-2">Link*</label>
                        <div class="col-xs-10">
                            <g:textField type="url" class="form-control" id="inputLink" name="url" placeholder="Link here"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputDescription" class="control-label col-xs-2">Description*</label>
                        <div class="col-xs-10">
                            <g:textArea id="inputDescription" class="form-control" name="description" placeholder="Description">
                            </g:textArea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="linkTopicSelect" class="control-label col-xs-2">Topic*</label>
                        <div class="col-xs-10">
                            <g:select class="form-control" id="linkTopicSelect" name="topicId" optionKey="id" from="${subscribedTopics}"></g:select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <g:submitButton name="share" type="submit" class="btn btn-primary">Share</g:submitButton>
                            <button  class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>